# Investment project

Notice : this project was developped on an Ubuntu OS, not Windows.

The technologies used into this project are :
* Angular 8 for the frontend
* Java 8 for the backend
* Elasticsearch for the database
* Linux shell bash for the script

## Set up the project environment on a Linux environment

### Java and Maven
We assume you already have java and maven installed on your pc

### Elasticsearch
First download the elasticsearch tar.gz file by clicking on the following link : https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-7.5.1-linux-x86_64.tar.gz
Then extract the tar.gz using the Linux shell bash command : [`tar -xzf elasticsearch-7.5.1-linux-x86_64.tar.gz`]

### Angular
To install Angular you first need Node.js version 10.9.0 or later and an npm package manager.
You can use nvm to help you in installing or updating Node.js and an npm.
To get nvm you can either install it normally [`https://github.com/nvm-sh/nvm#installing-and-updating`] or manually [`https://github.com/nvm-sh/nvm#manual-install`].
You can install the most recent version of node.js using nvm : [`nvm install node`].
Then install the most recent version of npm [`nvm install-latest-npm`].
To install the LTS versions instead you can use the [`--lts`] option.

Now You can install Angular by running [`npm install -g @angular/cli`]

## Run the applications

### Step 1 : Elasticsearch
To run the java backend app without issue Elasticsearch msut already be running. In order to start elasticsearch you must go into your extracted Elasticsearch folder, then go into the /bin directory, then execute the file called elasticsearch

### Step 2 : the backend application
Now in your local directory where you imported the investment project there is a folder called java-project which contains the java application. Inside java-project/, there is the folder target/ which contains the .jar file named Investment-1.0-SNAPSHOT.jar that you can run using the command : [`java -jar`] followed by the location of the .jar on your pc \{the directory where you downloaded the project\}/java-project/target/Investment-1.0-SNAPSHOT.jar

### Step 3 : the frontend application
to launch the Angular app go into the angular-project/ directory and run [`ng serve`]

## Use the application

### Use the app on the internet browser

The Angular application is available at the address [`http://localhost:4200/`].
There is a nav bar at the top with three pages, (Home), (Upload investments from a Json file), and (Display a list of investments from the server). If you want to import your investments into your database go on the second page. If you want to visualize the list of investments that you have already stored on Elasticsearch go on the last page.

### Import investments from a json file

Go on the page (Upload investments from a Json file), and (Display a list of investments from the server).
* First browse and choose the file to upload
* Once the the file has been selected and uploaded press the (Send the data) button

### View your imported investments

#### Show a table of investments

When you arrive on the page (Display a list of investments from the server) there are no investment displayed yet. You must first click on the [`Fetch all investments`] button or on the [`Filter by (one parameter or two)`] buttons.
The buttons to display a filtered list of investments on the right of the screen are available only after the needed text boxes on the left are filled accordingly.

#### Show a single investment

After a table of investments is shown at the bottom of the screen you can display the informations of one investment at a time. To do this you only have to click on the id of the desired investment.

## Import data into the Elasticsearch database using the Script instead of the Java and Angular applications

In the project directory there is a script file called [`ScriptStart.sh`].  This script allows you to import you investment data into your Elasticsearch database by having only elasticsearch running.

To use the script, run it and give it two parameters.
The first one is the http url endpoint configured in elasticsearch-7.5.1/config/elasticsearch.yml, usually localhost:9200 by default.
The second one is the path of the file.json, in the case of this test dataset.json.
