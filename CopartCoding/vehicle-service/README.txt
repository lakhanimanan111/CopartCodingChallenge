Vehicle Service 

This is a REST service performing CRUD operation on Vehicle Entity. vehicle-service-*-.war file has to be deployed in tomcat server for accessing the REST-end points for CRUD operation.


GET :

End-Point : http://localhost:8080/vehicle

http://localhost:8080/vehicle?make = make 
http://localhost:8080/vehicle?make = m*
http://localhost:8080/vehicle?make = model 
http://localhost:8080/vehicle?make = m*


POST : 

End-Point : http://localhost:8080/vehicle/

Body :

{
 "id":"6",
 "year":"2017",
 "make":"qq20s0d8",
 "model" : "yeah",
 "cClass":"Training"
 
}

PUT : 

End-Point : http://localhost:8080/vehicle/{vehicleID}
PathParam = vehicleIDs

Body :

{
 "id":"6",
 "year":"2017",
 "make":"qq20s0d8",
 "model" : "yeah",
 "cClass":"Training"
 
}

DELETE : http://localhost:8080/vehicle/{vehicleID}

PathParam = vehicleId



