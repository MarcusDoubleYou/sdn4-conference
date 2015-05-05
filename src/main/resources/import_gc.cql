LOAD CSV WITH HEADERS FROM "file:graphconnect_schedule.csv" as talk
WITH talk
WHERE NOT talk.Speaker IS NULL and NOT talk.Title IS NULL
MERGE (s:Session {name:talk.Title})
MERGE (tr:Track {name:talk.Track}) ON CREATE SET tr.room = talk.Room
MERGE (s)-[:IN_TRACK]->(tr)
MERGE (ts:Timeslot {date:talk.Date, start:talk.Starttime, end:talk.Endtime})
MERGE (s)-[:AT_TIME]->(ts)
MERGE (sp:Attendee {name:talk.Speaker}) 
  ON CREATE SET sp.position = talk.Position, sp:Speaker 
CREATE (sp)-[:PRESENTS]->(s)
RETURN count(*) AS talks;

