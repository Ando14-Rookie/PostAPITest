MainActivity.kt
Overview
This is the main activity of your Android application that facilitates interaction with the API to create a new user.

Key Components
Imports:
You import necessary classes from Android and Retrofit for network requests and UI handling.

Class Declaration:
The MainActivity class extends AppCompatActivity, which is part of the Android framework for UI activities.

TextView Variables:

You declare TextView variables (textName, textJob, textID, textCreated) to display the response data from the API.
onCreate Method:

This is the entry point when the activity is created.
Setting Content View:

setContentView(R.layout.activity_main) sets the layout for this activity.
Finding Views:

findViewById is used to link the declared TextView variables to their corresponding views in the XML layout.
Retrofit Setup:

You create a Retrofit instance:
Set the base URL to https://reqres.in.
Add a converter factory (GsonConverterFactory) to convert JSON responses into Kotlin objects.
Create an implementation of the APIFunction interface.
Making the API Call:

You use myAPI.createEmployee to send a POST request:
The first parameter is the API key for authentication.
The second parameter is a new RequestBody1 object containing the name and job to be sent.
Handling the Response:

The enqueue method handles the asynchronous request:
onResponse: This method is called when the request completes successfully.
If the response is successful (response.isSuccessful), you log the response and populate the TextView elements with data from the response body.
A Toast message confirms that the data was sent successfully.
onFailure: This method handles errors if the request fails, logging the error message.
APIFunction Interface
Overview
This interface defines the API endpoints your application can call.

@POST Annotation:

The @POST("/api/users") annotation specifies that this method will perform a POST request to the /api/users endpoint.
Method Parameters:

@Header("x-api-key") apiKey: String: This parameter includes the API key in the request header for authentication.
@Body requestBody: RequestBody1: This parameter takes the data object to be sent in the request body.
Return Type:

The method returns a Call<ResponseBody11>, which represents the expected response from the API.
ResponseBody.kt
Overview
This class models the expected structure of the response from the API.

Properties:
var name: String
var job: String
var id: Int
var createdAt: String
These properties correspond to the data returned when a new user is created.

RequestBody.kt
Overview
This class models the data you will send to the API when creating a new user.

Properties:
var name: String: The name of the user.
var job: String: The job title of the user.
