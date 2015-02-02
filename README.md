## This is Still Work in Progress Please Do not use This in Production

# logtrack

To Use LogTrack for Tracking your loggin Application please add this to your pom 

```
<dependency>
  <groupId>org.cybergen</groupId>
  <artifactId>logtrack</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>

<repositories>
    <repository>
        <id>logtrack-mvn-repo</id>
        <url>https://raw.github.com/vishnu667/logtrack/mvn-repo/</url>
        <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
        </snapshots>
    </repository>
</repositories>
```

Initialize the Logger to connect with the Cloud platform For Loggin all your Errors

```
import org.cybergen.LogTrack

LogTrack.initialize(Configuration config)
```

To monitor the Logs use 

```
LogTrack.log("your message");
```



Using the Alternate API for User Event Tracking 


Add this to your html page
```
var EventTracker = function() { };
    EventTracker.prototype.registerUser=function(eventName,username){
        $.ajax({
            url: 'http://tracker.cybergen.in/trackuser/1001?EVTNAME='+eventName+'&USRNAME='+username,
            contentType:"application/json",
            type : "POST",
            crossDomain: true,
            data: JSON.stringify({eventName:eventName,logLevel:username}),
            dataType: 'json',
            success: function(response)
            {
                console.log(response);
            }
        });
    EventTracker.prototype.sendEvent=function(eventName){
        $.ajax({
            url: 'http://tracker.cybergen.in/trackuser/1001?EVTNAME='+eventName+'&USRNAME=',
            contentType:"application/json",
            type : "POST",
            crossDomain: true,
            data: JSON.stringify({eventName:eventName}),
            dataType: 'json',
            success: function(response)
            {
                console.log(response);
            }
        });
};

```

to Register a Event for a Annononymous User
```
EventTracker.sendEvent("blog-click");
```

In order to register or track a particular User across your website enter the initial tracking email or other reference and the api will track the user across 

```
EventTracker.registerUser("subscription","vishnu667@gmail.com");
```







