# Springboot
POC - Microservices using Springboot
Following are the software required to be installed on the local machine for POC to work properly

1) Cassandra version 2.1.15

2) Redis

3) Elastic search

4) Log stash

5) Kibana

6) Use STS IDE or install STS plugin to eclipse

Cassandra

Following are the steps required

1) Start cassandra 

2) From the bin directory start cqlsh

3) From cqlsh run the following commands

CREATE KEYSPACE verizon WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 3 };

use verizon;

create table techSpec (id int, product text, title text, imageUrl text, techSpecFlag text, detailText text, primary key (id, product));

create index on techSpec(product);

insert into techSpec (id, product, title, techSpecFlag, detailText) values (1, 'dev3240009','Stand by time', 'true', '24 hrs');

insert into techSpec (id, product, title, techSpecFlag, detailText) values (2, 'dev3240009','Camera', 'true', '8 MP');

insert into techSpec (id, product, title, techSpecFlag, detailText) values (3, 'dev3240009','Weight', 'true', '6.07');

insert into techSpec (id, product, title, techSpecFlag, detailText) values (4, 'dev3240009','Storage', 'true', '16 GB, 64 GB, or 128 GB');

create table deviceFeature( id int, product text, imageUrl text, detailedText text, styleName text, title text, disclouserText text, smallImage text, imageOrVideUrl text, primary key (id, product));

create index on deviceFeature(product);

insert into deviceFeature(id, product, detailedText, title, smallImage, imageOrVideUrl) values (1, 'dev3240009', 'With innovations that deliver high contrast, dual domain pixedl for more acurate color','5.5 inch Retina HD display','https://mobile.vzw.com/hybridClient/is/image/', 'https://mobile.vzw.com/hybridClient/is/image/');

insert into deviceFeature(id, product, detailedText, title, smallImage, imageOrVideUrl) values (1, 'dev3240009', 'With innovations that deliver higher contrast, dual-domain pixels for more accurate color at wider viewing angles, and an improved polarizer, these are the thinnest, most advanced Multi-Touch displays.','5.5-inch (diagonal) Retina HD display with 1920x1080 resolution','https://mobile.vzw.com/hybridClient/is/image/VerizonWireless/icon-keyfeature-red-i-v1-1?$30x38$', 'https://mobile.vzw.com/hybridClient/is/image/VerizonWireless/pdp-iphone6plus-1-080515?$defaultscalejpg$&bgc=ffffff');

insert into deviceFeature(id, product, detailedText, title, smallImage, imageOrVideUrl) values (2, 'dev3240009', 'Its incredible power is enhanced by an M8 motion coprocessor that efficiently measures your activity from advanced sensors, including a new barometer. So you can do more, for longer periods of time, with better performance and battery life.','A8 chip with M8 motion coprocessor','https://mobile.vzw.com/hybridClient/is/image/VerizonWireless/icon-keyfeature-red-i-v1-1?$30x38$', 'https://mobile.vzw.com/hybridClient/is/image/VerizonWireless/pdp-iphone6plus-2-080515?$defaultscalejpg$&bgc=f6f6f6');

insert into deviceFeature(id, product, detailedText, title, smallImage, imageOrVideUrl) values (3, 'dev3240009', 'They support advanced camera and video features, like new Focus Pixels, better face detection, continuous autofocus, and enhanced noise reduction, so it&rsquo;s easier to shoot higher-quality photos and videos.','8MP iSight camera with FocusPixels, True Tone flash, & optical image stabilization','https://mobile.vzw.com/hybridClient/is/image/VerizonWireless/icon-keyfeature-red-i-v1-1?$30x38$', 'https://mobile.vzw.com/hybridClient/is/image/VerizonWireless/pdp-iphone6plus-3-080515?$defaultscalejpg$&bgc=e5e3e4');

insert into deviceFeature(id, product, detailedText, title, smallImage, imageOrVideUrl) values (4, 'dev3240009', 'It lets you shoot stunning 1080p HD video at 60 fps, capture more dramatic slo-mo video, and for the first time, create time-lapse videos. Continuous autofocus provides constant focus as you capture your footage. And cinematic video stabilization keeps your shots steady, even when youre not.','1080p HD video recording at 60 fps & slo-mo video recording at 240 fps','https://mobile.vzw.com/hybridClient/is/image/VerizonWireless/icon-keyfeature-red-i-v1-1?$30x38$', 'https://mobile.vzw.com/hybridClient/is/image/VerizonWireless/pdp-iphone6plus-4-080515?$defaultscalejpg$&bgc=ffffff');

Redis

1) Start redis server using command redid-server

Elastic Search

1) Start Elastic search using command elastic search

Logstash

1) Start log stash using command logstash -f logstash.conf

2) In logstash.conf file make sure the path of the application.log is pointing to correct location. Currently it contains the path on my mac machine.Make sure you provide the absolute path

Kibana

1) Start cabana using the command cabana

Importing project

1) Import project into IDE as Maven project.

2) In application.properties files under config-server project change the path to point to the git location on your local system

3) Two properties file would be required catalog.properties, device.properties, test.properties and vision.properties. The file would contain configuration information required by other projects and would be loaded by central config server.

4) Following is the content of each property file, make sure these files are committed to git.(Create a new folder and initialize it as git repository. Add the 2 files to git repository and then commit it to git. You don’t have to push it to remote server)

Catalog.properties

cassandra.contactpoints=localhost

cassandra.port=9042

cassandra.keyspace=verizon

vision.properties
vision_url=http://localhost:7777/test/dummy

5) If you have STS installed or STS plugin in eclipse you can start the servers from Boot Dashboard view. To get Boot Dashboard view from the Window menu of the IDE click on Show view and search for Boot Dashboard.

6) Start the config-server first followed by service-registry server, then you can start the remaining servers in any order
