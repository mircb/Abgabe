PATH=%PATH%;C:\Program Files (x86)\Java\jdk1.8.0_51\bin
REM wsimport -s src -p webservice.gen.geoipservice http://www.webservicex.net/geoipservice.asmx?WSDL
REM wsimport -d src -keep -p webservice.gen.mywebserviceservice http://localhost:8080/services?wsdl
REM wsimport -d src -keep -p webservice.gen.TempConvert http://localhost:8080/converter.asmx?wsdl
wsimport -d src -keep -p webservice.gen.Service http://localhost:8080/Service.svc?wsdl