/*
{
"talks": [{
  "title": "Building 'Bootiful' Applications",
  "abstract": "Alright, so maybe “bootiful” won’t ever work,...",
  "topics":  ["topic"],
  "room": "Auditorium",
  "timeslot": "Wed 29th, 11:00-11:50",
  "speaker": {
     "name": "Josh Long",
     "twitter": "https://twitter.com/starbuxman",
     "bio": "Josh Long is the Spring Developer Advocate...",
     "picture": ".../josh_long.jpeg" }}]}

*/

@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.2')
import groovyx.net.http.RESTClient
import groovy.json.JsonSlurper

def query = """
UNWIND {data}.talks as talk
CREATE (s:Session {title:talk.title,abstract:talk.abstract})
MERGE (r:Room {name:talk.room})
CREATE (s)-[:IN_ROOM]->(r)
MERGE (ts:Timeslot {date:split(talk.timeslot,", ")[0],time:split(talk.timeslot,", ")[1]})
CREATE (s)-[:AT_TIME]->(ts)
FOREACH (tp in talk.topics | MERGE (t:Topic {name:tp}) CREATE (s)-[:HAS_TOPIC]->(t))
WITH s,talk.speaker as speaker
MERGE (sp:Speaker {name:speaker.name})
  ON CREATE SET sp.bio = speaker.bio, sp.picture = sp.picture, sp:Attendee, sp.twitter = split(speaker.twitter,"/")[3]
CREATE (sp)-[:PRESENTS]->(s)
RETURN count(*) as talks"""

// Load JSON from File
def params = new JsonSlurper().parseText(new File("talks.json").text)

// send Cypher statement to Neo4j Server
def client = new RESTClient( 'http://localhost:7474', 'application/json' )
def resp = client.post( path : '/db/data/transaction/commit', body : [statements:[[statement:query,parameters:[data:params]]]] )

assert resp.status == 200
assert resp.data.errors.isEmpty()
def talks = resp.data.results[0].data[0].row[0]
assert talks > 0
println "Inserted "+talks+" talks."