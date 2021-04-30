# GoogleSheetReader
To run project in eclipse follow below steps.
1. import project from git to eclipse.
2. create app in goolge engine and enable google sheet api.
3. After creating app put credential file in resource folder of porject.
4. run project as spring boot project.
5. copy verification url from console and run it in browser.
6. check Controller class for end points.
End point exmaple:
1. to get metdata
  http://host:port/v1/metadata/{sheetid}
2. to get data of specific sheetid and sheetname
  http://localhost:8080/v1/data/{sheetid}/{sheetname}
