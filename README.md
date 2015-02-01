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



