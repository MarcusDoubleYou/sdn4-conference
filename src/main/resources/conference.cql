create (conference:Conference {name : 'Spring I/O Barcelona 2015'})

create (track1:Track {name : 'Track 1 (Auditorium)'})
create (track2:Track {name : 'Track 2 (Room 1)'})
create (track3:Track {name : 'Track 3 (Room 3)'})
create (track4:Track {name : 'Track 4 (Room 2)'})

create (conference)<-[:REGISTERED_FOR]-(long:Attendee:Speaker {name : 'Josh Long'})
create (conference)<-[:REGISTERED_FOR]-(gonzalez:Attendee:Speaker {name : 'Ignasi Gonzalez'})
create (conference)<-[:REGISTERED_FOR]-(lopez:Attendee:Speaker {name : 'Ivan Lopez'})
create (conference)<-[:REGISTERED_FOR]-(rodriguez:Attendee:Speaker {name : 'Anton Rodriguez'})
create (conference)<-[:REGISTERED_FOR]-(deleuze:Attendee:Speaker {name : 'Sebastien Deleuze'})
create (conference)<-[:REGISTERED_FOR]-(stoyanchev:Attendee:Speaker {name : 'Rossan Stoyanchev'})
create (conference)<-[:REGISTERED_FOR]-(strobel:Attendee:Speaker {name : 'Christoph Strobel'})
create (conference)<-[:REGISTERED_FOR]-(syer:Attendee:Speaker {name : 'Dave Syer'})
create (conference)<-[:REGISTERED_FOR]-(gee:Attendee:Speaker {name : 'Trisha Gee'})
create (conference)<-[:REGISTERED_FOR]-(maki:Attendee:Speaker {name : 'Toshiaki Maki'})

create (conference)<-[:REGISTERED_FOR]-(nicoll:Attendee:Speaker {name : 'Stephane Nicoll'})
create (conference)<-[:REGISTERED_FOR]-(sanchez:Attendee:Speaker {name : 'Alvaro Sanchez-Mariscal'})
create (conference)<-[:REGISTERED_FOR]-(kleine:Attendee:Speaker {name : 'Moritz Kleine'})
create (conference)<-[:REGISTERED_FOR]-(darimont:Attendee:Speaker {name : 'Thomas Darimont'})
create (conference)<-[:REGISTERED_FOR]-(ekblad:Attendee:Speaker {name : 'Sami Ekblad'})
create (conference)<-[:REGISTERED_FOR]-(cebron:Attendee:Speaker {name : 'Yann Cebron'})
create (conference)<-[:REGISTERED_FOR]-(casau:Attendee:Speaker {name : 'Fatima Casau'})
create (conference)<-[:REGISTERED_FOR]-(paraschiv:Attendee:Speaker {name : 'Eugen Paraschiv'})
create (conference)<-[:REGISTERED_FOR]-(doguin:Attendee:Speaker {name : 'Laurent Doguin'})
create (conference)<-[:REGISTERED_FOR]-(clozel:Attendee:Speaker {name : 'Brian Clozel'})

create (conference)<-[:REGISTERED_FOR]-(gomez:Attendee:Speaker {name : 'David Gomez'})
create (conference)<-[:REGISTERED_FOR]-(almar:Attendee:Speaker {name : 'Sergi Almar'})
create (conference)<-[:REGISTERED_FOR]-(davies:Attendee:Speaker {name : 'John Davies'})
create (conference)<-[:REGISTERED_FOR]-(leite:Attendee:Speaker {name : 'Norberto Leite'})
create (conference)<-[:REGISTERED_FOR]-(redondo:Attendee:Speaker {name : 'Fernando Redondo'})
create (conference)<-[:REGISTERED_FOR]-(gierke:Attendee:Speaker {name : 'Oliver Gierke'})
create (conference)<-[:REGISTERED_FOR]-(brennan:Attendee:Speaker {name : 'Sam Brennan'})
create (conference)<-[:REGISTERED_FOR]-(maldini:Attendee:Speaker {name : 'Stephane Maldini'})
create (conference)<-[:REGISTERED_FOR]-(hunger:Attendee:Speaker {name : 'Michael Hunger'})
create (conference)<-[:REGISTERED_FOR]-(bickers:Attendee:Speaker {name : 'Vince Bickers'})

create (conference)<-[:REGISTERED_FOR]-(whittle:Attendee:Speaker {name : 'Dustin Whittle'})
create (conference)<-[:REGISTERED_FOR]-(dubois:Attendee:Speaker {name : 'Julien Dubois'})
create (conference)<-[:REGISTERED_FOR]-(frankel:Attendee:Speaker {name : 'Nicolas Frankel'})
create (conference)<-[:REGISTERED_FOR]-(selajev:Attendee:Speaker {name : 'Oleg Selajev'})
create (conference)<-[:REGISTERED_FOR]-(mattson:Attendee:Speaker {name : 'Tobias Mattson'})
create (conference)<-[:REGISTERED_FOR]-(soto:Attendee:Speaker {name : 'Alex Soto'})
create (conference)<-[:REGISTERED_FOR]-(gormley:Attendee:Speaker {name : 'Clinton Gormley'})
create (conference)<-[:REGISTERED_FOR]-(tsang:Attendee:Speaker {name : 'Ray Tsang'})
create (conference)<-[:REGISTERED_FOR]-(deinum:Attendee:Speaker {name : 'Martin Deinum'})
create (conference)<-[:REGISTERED_FOR]-(samper:Attendee:Speaker {name : 'Jose Samper'})

create (conference)<-[:REGISTERED_FOR]-(hoeller:Attendee:Speaker {name : 'Juergen Hoeller'})


create (springdata:Topic { name :  'Spring Data' })
create (springboot:Topic { name :  'Spring Boot' })
create (springmvc:Topic { name :  'Spring MVC' })
create (springxd:Topic { name :  'Spring XD' })
create (springbatch:Topic { name :  'Spring Batch' })
create (springcloud:Topic { name : 'Spring Cloud' })
create (springsession:Topic { name : 'Spring Session' })
create (springintegration:Topic { name : 'Spring Integration' })

create (nashorn:Topic { name :  'Nashorn' })
create (react:Topic { name :  'React' })
create (angular:Topic { name :  'Angular js' })
create (jhipster:Topic { name :  'JHipster' })
create (cloudfoundry:Topic { name :  'CloudFoundry' })
create (thymeleaf:Topic { name :  'Thymeleaf' })
create (testing:Topic { name :  'Testing' })
create (mongodb:Topic { name :  'MongoDB' })
create (neo4j:Topic { name :  'Neo4j' })
create (ratpack:Topic { name :  'Ratpack' })
create (couchbase:Topic { name :  'Couchbase' })
create (microservices:Topic { name :  'Microservices' })
create (grails:Topic { name :  'Grails' })
create (groovy:Topic { name :  'Groovy' })
create (java:Topic { name :  'Java' })
create (devops:Topic { name :  'Devops' })

create (long)-[:PRESENTS]->(session1:Session {name : 'Building “Bootiful” Applications with Spring Boot'})
create (session1)-[:HAS_TOPIC]->(springboot)

create (gonzalez)-[:PRESENTS]->(session2:Session {name : 'Spring Batch for Large Enterprises Operations'})
create (session2)-[:HAS_TOPIC]->(springbatch)

create (lopez)-[:PRESENTS]->(session3:Session {name : 'Mum, I want to be a Groovy full-stack developer '})
create (session3)-[:HAS_TOPIC]->(groovy)

create (rodriguez)-[:PRESENTS]->(session4:Session {name : 'Using Groovy to empower WebRTC Network Systems (Workshop)'})
create (session4)-[:HAS_TOPIC]->(groovy)

create (stoyanchev)-[:PRESENTS]->(session5:Session {name : 'Spring 4 Web Apps '})
create (session5)-[:HAS_TOPIC]->(springmvc)

create (strobl)-[:PRESENTS]->(session6:Session {name : 'Boot your Search with Spring '})


create (deleuze)-[:PRESENTS]->(session7:Session {name : 'Isomorphic templating with Spring Boot, Nashorn and React'})
create (session7)-[:HAS_TOPIC]->(springboot)
create (session7)-[:HAS_TOPIC]->(nashorn)
create (session7)-[:HAS_TOPIC]->(react)

create (syer)-[:PRESENTS]->(session8:Session {name : 'Building Microservices with Spring Cloud and Netflix OSS'})
create (session8)-[:HAS_TOPIC]->(microservices)
create (session8)-[:HAS_TOPIC]->(springcloud)

create (gee)-[:PRESENTS]->(session9:Session {name : 'Is Groovy better for testing than Java? '})
create (session9)-[:HAS_TOPIC]->(groovy)
create (session9)-[:HAS_TOPIC]->(java)

create (maki)-[:PRESENTS]->(session10:Session {name : 'TERASOLUNA Framework on the Spring IO Platform '})

create (darimont)-[:PRESENTS]->(session11:Session {name : 'Spring XD in Action (Workshop)'})
create (session11)-[:HAS_TOPIC]->(springxd)

create (nicoll)-[:PRESENTS]->(session12:Session {name : 'Master Spring Boot auto-configuration'})
create (session12)-[:HAS_TOPIC]->(springboot)

create (sanchez)-[:PRESENTS]->(session13:Session {name : 'Stateless Authentication for Microservices'})
create (session13)-[:HAS_TOPIC]->(microservices)

create (kleine)-[:PRESENTS]->(session14:Session {name : 'Developing and Maintaining Spring-based Enterprise Software: Lessons Learned'})


create (ekblad)-[:PRESENTS]->(session15:Session {name : 'How to Rock your Web Apps with Spring'})
create (session15)-[:HAS_TOPIC]->(springmvc)

create (cebron)-[:PRESENTS]->(session16:Session {name : 'Spring Boot is made for tooling '})
create (nicoll)-[:PRESENTS]->(session16)
create (session11)-[:HAS_TOPIC]->(springboot)

create (casau)-[:PRESENTS]->(session17:Session {name : 'Micro-Services Grails or Spring Boot?'})
create (session17)-[:HAS_TOPIC]->(grails)
create (session17)-[:HAS_TOPIC]->(springboot)
create (session17)-[:HAS_TOPIC]->(microservices)

create (clozel)-[:PRESENTS]->(session18:Session {name : 'Static Resources Management with Spring and Single Page Applications (Workshop) '})

create (hoeller)-[:PRESENTS]->(session19:Session {name : 'Modern Java Component Design with Spring 4.2'})
create (session19)-[:HAS_TOPIC]->(java)

create (paraschiv)-[:PRESENTS]->(session20:Session {name : 'Inside an Spring Event Sourced CQRS application – or why Microservices can actually work '})
create (session20)-[:HAS_TOPIC]->(microservices)

create (doguin)-[:PRESENTS]->(session21:Session {name : 'Manage time-based data with Spring Data Couchbase'})
create (long)-[:PRESENTS]->(session21)
create (session21)-[:HAS_TOPIC]->(couchbase)
create (session21)-[:HAS_TOPIC]->(springdata)

create (darimont)-[:PRESENTS]->(session22:Session {name : 'Creating Big Data applications with Spring XD'})
create (session22)-[:HAS_TOPIC]->(springxd)

create (clozel)-[:PRESENTS]->(session23:Session {name : 'Inside http://spring.io – a production spring reference application'})

create (gomez)-[:PRESENTS]->(session24:Session {name : 'Manage your user’s session with Spring Session'})
create (session24)-[:HAS_TOPIC]->(springsession)

create (redondo)-[:PRESENTS]->(session25:Session {name : 'Spock: testing (in the) Enterprise (Workshop)'})
create (session25)-[:HAS_TOPIC]->(testing)

create (almar)-[:PRESENTS]->(session26:Session {name : 'Real-time with Spring: SSE and WebSockets'})

create (davies)-[:PRESENTS]->(session27:Session {name : 'High Performance Spring Integration'})
create (session27)-[:HAS_TOPIC]->(springintegration)

create (leite)-[:PRESENTS]->(session28:Session {name : 'MongoDB and Spring – Two leaves of a same tree'})
create (session28)-[:HAS_TOPIC]->(springdata)
create (session28)-[:HAS_TOPIC]->(mongodb)

create (gierke)-[:PRESENTS]->(session29:Session {name : 'Spring Data REST – Repositories meet hypermedia'})
create (session29)-[:HAS_TOPIC]->(springdata)


create (brannen)-[:PRESENTS]->(session30:Session {name : 'Testing with Spring 4.x'})
create (session30)-[:HAS_TOPIC]->(testing)

create (maldini)-[:PRESENTS]->(session31:Session {name : 'Designing for Distributed Systems with Reactor and Reactive Streams'})

create (sanchez)-[:PRESENTS]->(session32:Session {name : 'Ratpack 101 (Workshop)'})
create (session32)-[:HAS_TOPIC]->(ratpack)

create (hunger)-[:PRESENTS]->(session33:Session {name : 'Building High Performance Applications with Spring Data Neo4j 4.0'})
create (bickers)-[:PRESENTS]->(session33)
create (session33)-[:HAS_TOPIC]->(springdata)
create (session33)-[:HAS_TOPIC]->(springboot)
create (session33)-[:HAS_TOPIC]->(neo4j)
create (session33)-[:HAS_TOPIC]->(angular)

create (long)-[:PRESENTS]->(session34:Session {name : 'Can Your Cloud Do This? Getting Started with Cloud Foundry'})
create (session34)-[:HAS_TOPIC]->(springcloud)

create (whittle)-[:PRESENTS]->(session35:Session {name : 'Performance Testing Crash Course'})
create (session35)-[:HAS_TOPIC]->(testing)

create (dubois)-[:PRESENTS]->(session36:Session {name : 'JHipster, the leading application generator for Spring Boot + AngularJS'})
create (session36)-[:HAS_TOPIC]->(springboot)
create (session36)-[:HAS_TOPIC]->(jhipster)
create (session36)-[:HAS_TOPIC]->(angular)

create (frankel)-[:PRESENTS]->(session37:Session {name : 'Spring Boot for Devops '})
create (session37)-[:HAS_TOPIC]->(devops)
create (session37)-[:HAS_TOPIC]->(springboot)

create (selajev)-[:PRESENTS]->(session38:Session {name : 'Everything you need to know about Java Classloaders'})
create (session38)-[:HAS_TOPIC]->(java)

create (long)-[:PRESENTS]->(session39:Session {name : 'Building “Bootiful” Microservices with Spring Cloud (Workshop)'})
create (session39)-[:HAS_TOPIC]->(springcloud)
create (session39)-[:HAS_TOPIC]->(springboot)

create (tsang)-[:PRESENTS]->(session40:Session {name : 'Spring-Boot Microservices, Container, Kubernetes – How To'})
create (session40)-[:HAS_TOPIC]->(springboot)

create (deinum)-[:PRESENTS]->(session41:Session {name : 'Improving your (legacy) Application with Spring'})

create (samper)-[:PRESENTS]->(session42:Session {name : 'A Brief History of Thymeleaf'})
create (session42)-[:HAS_TOPIC]->(thymeleaf)


create (session1)-[:IN_TRACK]->(track1)
create (session2)-[:IN_TRACK]->(track2)
create (session3)-[:IN_TRACK]->(track3)
create (session4)-[:IN_TRACK]->(track4)
create (session5)-[:IN_TRACK]->(track1)
create (session6)-[:IN_TRACK]->(track2)
create (session7)-[:IN_TRACK]->(track3)

create (session8)-[:IN_TRACK]->(track1)
create (session9)-[:IN_TRACK]->(track2)
create (session10)-[:IN_TRACK]->(track3)
create (session11)-[:IN_TRACK]->(track4)
create (session12)-[:IN_TRACK]->(track1)
create (session13)-[:IN_TRACK]->(track2)
create (session14)-[:IN_TRACK]->(track3)

create (session15)-[:IN_TRACK]->(track1)
create (session16)-[:IN_TRACK]->(track2)
create (session17)-[:IN_TRACK]->(track3)
create (session18)-[:IN_TRACK]->(track4)
create (session19)-[:IN_TRACK]->(track1)
create (session20)-[:IN_TRACK]->(track2)
create (session21)-[:IN_TRACK]->(track3)

create (session22)-[:IN_TRACK]->(track1)
create (session23)-[:IN_TRACK]->(track2)
create (session24)-[:IN_TRACK]->(track3)
create (session25)-[:IN_TRACK]->(track4)
create (session26)-[:IN_TRACK]->(track1)
create (session27)-[:IN_TRACK]->(track2)
create (session28)-[:IN_TRACK]->(track3)

create (session29)-[:IN_TRACK]->(track1)
create (session30)-[:IN_TRACK]->(track2)
create (session31)-[:IN_TRACK]->(track3)
create (session32)-[:IN_TRACK]->(track4)
create (session33)-[:IN_TRACK]->(track1)
create (session34)-[:IN_TRACK]->(track2)
create (session35)-[:IN_TRACK]->(track3)

create (session36)-[:IN_TRACK]->(track1)
create (session37)-[:IN_TRACK]->(track2)
create (session38)-[:IN_TRACK]->(track3)
create (session39)-[:IN_TRACK]->(track4)
create (session40)-[:IN_TRACK]->(track1)
create (session41)-[:IN_TRACK]->(track2)
create (session42)-[:IN_TRACK]->(track3)


































































































































































































































































































