# employeeApp
- This project is a demo of a web service using Spring MVC and Hibernate, capable of processing JSON or XML requests.
- Oracle XE-11.2.0 database is used, create schema as defined in "employee-ws/src/main/resources/com/rsingal/employee/dbSchema/createSchema.sql".
- Maven is used for build dependencies, with two modules - employee-ws-api and employee-ws having a parent employeeApp/pom.xml
- employee-ws-api module has API's for Web Service, along with XSD of the API's and hibernate validators.
- employee-ws module has spring controllers and communicate with DB using hibernate.
- Build employee-ws-api to generate XSD using maven plugin: jaxb2-maven-plugin 
	~/workspace/employeeApp/employee-ws-api > mvn clean install
- Path of XSD: "employee-ws-api/src/main/resources/com/rsingal/employee/xsdSchema/*.xsd"
- Build and Run employee-ws module using maven:
	~/workspace/employeeApp/employee-ws > mvn clean install
	~/workspace/employeeApp/employee-ws > mvn clean tomcat7:run
- Below are some sample request and response of web service:
---------------------------------------------------------------------
Positive Scenario's	
---------------------------------------------------------------------
Request:
	Method:		POST
	URL:		http://localhost:8080/employee/createEmployee
	Header:		Content-Type: application/json
				Accept: application/json
	Payload:
				{
					"name": "Ramesh Singal",
					"age": 33
				}
Response:
				{
					"employeeId": 1
				}
---------------------------------------------------------------------
Request:
	Method:		POST
	URL:		http://localhost:8080/employee/createEmployee
	Header:		Content-Type: application/xml
				Accept: application/xml
	Payload:
				<CreateEmployeeRequest>
					<name>Manish B</name>
					<age>35</age>
				</CreateEmployeeRequest>
Response:
				<CreateEmployeeResponse>
					<employeeId>2</employeeId>
				</CreateEmployeeResponse>
---------------------------------------------------------------------
Request:
	Method:		GET
	URL:		http://localhost:8080/employee/getEmployees
	Header:		Content-Type: application/json
				Accept: application/json
Response:
				{
					"employees": [{
						"employeeId": 1,
						"name": "Ramesh Singal",
						"age": 33
					},
					{
						"employeeId": 2,
						"name": "Manish B",
						"age": 35
					}],
				}
---------------------------------------------------------------------
Request:
	Method:		GET
	URL:		http://localhost:8080/employee/getEmployees/1
	Header:		Content-Type: application/json
				Accept: application/json
Response:
				{
					"employeeId": 1,
					"name": "Ramesh Singal",
					"age": 33
				}
---------------------------------------------------------------------
Request:
	Method:		POST
	URL:		http://localhost:8080/employee/updateEmployee
	Header:		Content-Type: application/json
				Accept: application/json
	Payload:
				{
					"employeeId": 1,
					"name": "Ramesh S",
					"age": 33
				}
Response:
				{}
---------------------------------------------------------------------
Request:
	Method:		POST
	URL:		http://localhost:8080/employee/deleteEmployee
	Header:		Content-Type: application/json
				Accept: application/json
	Payload:
				{
					"employeeId": 2
				}
Response:
				{}

---------------------------------------------------------------------
Negative Scenario's	
---------------------------------------------------------------------
Request:
	Method:		POST
	URL:		http://localhost:8080/employee/createEmployee
	Header:		Content-Type: application/json
				Accept: application/json
	Payload:
				{
					"age": 0
				}
Response:
				{
					"errorCode": 400,
					"errorMessage": "Binding Error",
					"errorDetails": [	"name - can not be null or blank",
								"age - must be between 1 and 100"
							],
				}
---------------------------------------------------------------------

