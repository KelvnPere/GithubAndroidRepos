
#Retrofit Example

This is an Android app that retreives the most starred android repository on Github.


## Getting Started

Just clone or download the repository.

### Who can use this project?

Anyone can clone this and use this project.

### Tools used for the projects

 Retrofit which is a type safe HTTP client for Android and Java built by square (http://square.github.io/retrofit/)


### GitHub Api Response in JSON


```
{
  "total_count": 42059,
  "incomplete_results": false,
  "items": [
    {
      "id": 51148780,
      "node_id": "MDEwOlJlcG9zaXRvcnk1MTE0ODc4MA==",
      "name": "android-architecture",
      "full_name": "googlesamples/android-architecture",
      "private": false,
      },
 ```


```

### A little explanation

Creating an interface is required, my interface name was Api (you can use any name) here to manage your url calls. And then you specify what type of request,
you want to make. I made a GET, which just fetches some information. You can make a POST, UPDATE or DELETE. it all depends on your need. T

 The beautiful thing about retrofit is that, it works in the background and it doesn't block your main thread, by callinng the enqueue method which returns 2 methods that needs 
 to be implemented.

```


```



