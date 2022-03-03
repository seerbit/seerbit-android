<p align="center">
<img width="500" valign="top" src="https://res.cloudinary.com/dpejkbof5/image/upload/v1620323718/Seerbit_logo_png_ddcor4.png" data-canonical-src="https://res.cloudinary.com/dpejkbof5/image/upload/v1620323718/Seerbit_logo_png_ddcor4.png" style="max-width:100%; ">
</p>

# Seerbit Android SDK

Seerit Android SDK can be used to integrate the SeerBit payment gateway into your Android application.

## Requirements
Register for a merchant account on [Seerbit Merchant Dashboard](https://dashboard.seerbitapi.com) to get started.
To get a Git project into your build:



Step 1. Add the JitPack repository to your build file

### Gradle
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.seerbit:seerbit-android:1.1.5'
	}


### Maven
Step 1. Add the JitPack repository to your build file

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

Step 2. Add the dependency

	<dependency>
	    <groupId>com.github.seerbit</groupId>
	    <artifactId>seerbit-android</artifactId>
	    <version>1.1.5</version>
	</dependency>
## API Documentation
https://doc.seerbit.com

## Support
If you have any problems, questions or suggestions, create an issue here or send your inquiry to developers@seerbit.com

## Implementation
You should already have your API keys. If not, go to [dashboard.seerbitapi.com](https://dashboard.seerbitapi.com).

## Quick Start

```xml
<FrameLayout
    android:id="@+id/view"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toTopOf="parent"/>
```

Next create an instance of a seerbit view and add it into a framelayout
```java

FrameLayout webView = findViewById(R.id.view);

//Create a new transaction model
TransactionModel transactionModel = new TransactionModel();
String transRef = ""+System.currentTimeMillis();
transactionModel.setTranref(transRef);
transactionModel.setCurrency("your currency");
transactionModel.setEmail("your email address");
transactionModel.setAmount(your amount in integer);
transactionModel.setDescription("your description");
transactionModel.setCountry("your country");
transactionModel.setCallbackurl("https://yourcallbackurl.com");
transactionModel.setPublic_key("your public key");
transactionModel.setFull_name("full name");
transactionModel.setClose_on_success(false);

//Create a new instance of seerbitview
SeerbitView seerbitWebView = new SeerbitView(this);
webView.addView(seerbitWebView);

// opens the view with the defined transaction model
seerbitWebView.open(transactionModel);
	
//add a EventListener to listen to various states of the sdk
seerbitWebView.addEventListener(new SeerbitView.EventsListener() {
     @Override
     public void OnCompleteListener(SuccessModel successModel) {
     	//get data associated with transaction
     	Log.d(TAG, "OnCompleteListener: "+successModel.getResponse().getPayments().getCountry());
	//Close the webivew
        seerbitWebView.close();
     }

     @Override
     public void onCloseListener() {
         //Case whem the user cancels the transaction manually
         seerbitWebView.close();
     }

     @Override
     public void onError() {
          //Something went wrong close transaction
           seerbitWebView.close();
       }

    });
```

## API Documentation
The following sections provides detailed documentation for every component in the library.


### TransactionModel
A transaction model is used for passing data to seerbit SDK, it contains details such as the transaction reference, the currency of the transaction, the email, the amount, the description, country, callback url (which is a url used for callbacks), your public key, and the full name. In order for seerbit SDK to open a valid transaction model all these values must be set before calling the .open() method. If not the seerbit SDK might not be initialized properly. This is an example of a valid transaction model
```java
TransactionModel transactionModel = new TransactionModel();
/*
transRef-> String: Used as a transaction reference
*/
String transRef = ""+System.currentTimeMillis();
transactionModel.setTranref(transRef);
/**
 Currency-> String: Used to specify the currency of payment
 */
transactionModel.setCurrency("NGN");
/**
 Email-> String: Used to specify the email attached to the transaction
*/
transactionModel.setEmail("seerbittest@gmail.com");
/**
 Amount-> int: Used to specify the amount of payment to be made
*/
transactionModel.setAmount(100);
/**
 Description-> String: Used to specify the description of the payment
 */
transactionModel.setDescription("Payment of bils");
/**
 Country-> String: Used to specify the Country
*/
transactionModel.setCountry("NG");
/**
Callbackurl-> String: Used to specify the callback 
url this can be passed as an empty string if none is avaliable
*/
transactionModel.setCallbackurl("https://whatever.com");
/**
 Public key-> String: Used to specify the public key associated with the developers account
*/
transactionModel.setPublic_key("public key");
/**
 *Fullname-> String: Used to specify the full name associated with the payment
*/
transactionModel.setFull_name("Seer Bit");

/**
*Close on Success -> Boolean: Used to tell thw SDK whether to close immediately after a successful transaction or not (defaults to true)
*/
transactionModel.setClose_on_success(false);


```
### Closing the seerbit SDK

In case the need ever arises to manually close the seerbit SDK. There is a method that can be used to release all resources associated with the view. This is done by using the .close() which takes in no arguments.

### State flow of the API

The expected workflow of the API is to firstly create an instance of the seerbit SDK, the call the .open() method by passing it a transaction model to open, the view is automatically closed after a successful transaction. click [here](https://github.com/seerbit/seerbit-android/tree/master/app) for an example app


## Contributors
<span>
<a href="https://github.com/adewoleopeyemi" title="Adewole Opeyemi">
  <img src="https://github.com/adewoleopeyemi.png?size=50">
</a>

<a href="https://github.com/amoskeyz">
  <img src="https://github.com/amoskeyz.png?size=50">
</a>
</a>
   <a href="https://github.com/victorighalo" title="Victor Ighalo">
  <img src="https://github.com/victorighalo.png?size=50">
</a>
   </span>
