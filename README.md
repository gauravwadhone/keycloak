# keycloak

keycloak-restapi-demo is sample app to create custom rest api for keycloak.

Once deployed it provide all user details (first name / last name / user name ) without providing JWT token or user/password.

To execute build the jar by running mvn install and copy the jar to keycloak's deployment folder.

and execute the below curl command to retrive user details.

```
curl  -s -X GET   "http://localhost:8180/auth/realms/GW/gaurav-rest/users" | jq
[
  {
    "userName": "gaurav",
    "firstName": "gaurav",
    "lastName": "wadhone"
  },
  {
    "userName": "testuser",
    "firstName": "test",
    "lastName": "user"
  },
  {
    "userName": "testuser2",
    "firstName": "test",
    "lastName": "user2"
  }
]
                              
```
