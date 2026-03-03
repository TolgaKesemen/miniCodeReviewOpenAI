# miniCodeReviewOpenAI
Java17 ve springboot-3 versiyonu kullanılarak openAI entegrasyonu ile code generation ve code review yapan rest uygulamasıdır.
OpenAI modeli olarak gpt-4o-mini modeli kullanılmaktadır. 

Code generation yapan servis, istenilen iş parçacığının tanımı ve daha önce hazırlanan prompt ile openAI servisini çağırmaktadır.
Bu prompt içerisinde modeli java17 ve springboot-3 konsunda senior developer olduğu belirtilmektedir. 

Code reivew yapan servis, requestten gelen code bloğu ve daha önce hazırlanan prompt ile openAI servisini çağırmaktadır.
Bu prompt içerisinde modeli java17 ve springboot-3 konsunda senior developer olduğu belirtilmekle birlikte clean code, solid principles vb kriterlere göre çalışmaktadır.
