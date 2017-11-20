/**
Names: Charles Butler   

Description: 
Decide on a list of n favorites (songs, bands, movies, video games, etc.) (between 5 and 10 favorites is fine).
Write a program that lists the n favorites but with a small twist.
Read in a file of n favorites (sample file in the Resources/Sample File area)...Please make your own.
Print a list of all n favorites to the user (so they know what is coming)
Ask if the user wishes to add or delete elements to/from the list.
If they wish to add an element, read in the element from the console
If they wish to remove an element, prompt for the item to be removed.
Print the next favorite from the list and for each favorite....
1st prompt for the user’s ranking of the favorite
 2nd prompt for the user’s comments (for this round)
Slot the favorite into the final list using the supplied flowchart
Inform the user of the placement of the latest element.
After all n favorites, print the list to the screen
When complete, write back to the input file, adding the new comments to the previous rounds of comments.
The file should be able to be consumed by your program for the next round of play.
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;// import stuff
public class FavoriteListOrganizer {
	

public static void main(String[] args) {
int noDoc = 0;
boolean numberError = false;//declare a bunch of variables
int enteredNumber = 0;
String enteredString = "";
String emptyLine = "";
BufferedReader reader = null;
int currentLinecounter = 0;
Scanner keyboard = new Scanner(System.in);//declare scanner method
ArrayList <String> myFileLines = new ArrayList <String>();
ArrayList <String> Rankings = new ArrayList <>();
ArrayList <String> Comments = new ArrayList <String>();//these 3 array lists take in and store each line as an element and then are added to comment and ranking arrays as elements
while (noDoc == 0)//this while loop checks if a document is real

{

noDoc = 1;

System.out.println("Please enter a file in the following format (for windows only): C:\\users\\your_name\\location\\document_name.txt ");

System.out.println("Example: C:\\users\\John\\Desktop\\Cars.txt");

System.out.println("NOTE: Entry is case sensitive");//prints out some messages

String enteredString3 = keyboard.nextLine();//takes in the users input for the file theyre searching for
try {
String sCurrentLine;
reader = new BufferedReader(new FileReader(enteredString3));//reads in a file of your choosing
int numberofLines = 0;
while ((sCurrentLine = reader.readLine()) != null) {//while there are lines in the file read them

myFileLines.add(sCurrentLine);

}

} catch (IOException e) {

System.out.println("We could not find that file");//catch to make sure the user enter the correct file

noDoc = 0;

System.out.println("");


}


finally {

try {


if (reader != null)reader.close();//if there arent any more lines to read in the file this closes

} catch (IOException ex) {//catches the exception of there being no files
noDoc = 0;

System.out.println("I'm sorry there has been an error loading your file...Please re-enter your file name to continue");


ex.printStackTrace();

}
}
}


System.out.println("Here are your favorites");//prints out the list of favorites
for (int i = 0; i < myFileLines.size(); i++)

{



System.out.println(myFileLines.get(i));


}
int addDelete = 1;
while(addDelete == 1)//while loop for checking if the user wants to add or delete something
{
	 String add = new String("add");//strings for adding or deleting
	 String delete = new String("delete");
	 String no = new String("no");
	
		
System.out.println("Would you like to add or delete an item from the list (add, delete, or no)?");
keyboard = new Scanner (System.in);//takes in user input for add delete or no
String input4 = keyboard.nextLine();
 if(input4.equalsIgnoreCase(add))//if the input is add
 {
	
   
    System.out.println("Please enter an item to add");
    String favAdd = keyboard.nextLine();//takes in item that user can add
    if(myFileLines.contains(favAdd)) //checks if item is already on the list
    {
    	 System.out.println("That item is already on the list");
    }
    else
    {
    myFileLines.add(favAdd);//otherwise adds the new item
    System.out.println("The item " + favAdd + " has been added to the list");
    System.out.println("");
    System.out.println("Here is your new list of favorites");
    for (int i = 0; i < myFileLines.size(); i++)//prints out new list of favorites

    {

    System.out.println(myFileLines.get(i));
    }
    }
 }
 else if(input4.equalsIgnoreCase(delete))//same with delete
 {
    
    System.out.println("Please enter an item from the list to delete");
    String favDel = keyboard.nextLine();//user enters an item
    if(!myFileLines.contains(favDel)) //if item is on list it doesnt let you delete it
    {
    	 System.out.println("That is not an item on the list");
    }
    else
    {
    myFileLines.remove(favDel);//otherwise it removes the item from the list
    System.out.println("The item " + favDel + " has been deleted from the list");
    System.out.println("");
    System.out.println("Here is your new list of favorites");//prints out new list
    for (int i = 0; i < myFileLines.size(); i++)

    {

    System.out.println(myFileLines.get(i));
    }
    
   
   
    }
 }
 else if(input4.equalsIgnoreCase(no))//if user types no code continues on and prints out list of favs
 {
    
    System.out.println("Time to rank your favorites!");
    addDelete = 0;
 
 }
 else {
	 System.out.println("That is not a valid entry");
	
 }
}
System.out.println("Here is your final list of favorites");
for (int i = 0; i < myFileLines.size(); i++)

{

System.out.println(myFileLines.get(i));
}

//System.out.println(myFileLines.size());

for (int i = 0; i <= myFileLines.size(); i++)//this adds a empty line to a ranking array the same length as the file line array


{

Rankings.add(emptyLine);

}

//System.out.println(Rankings.size());

Rankings.set(0, "");

for (int i = 0; i <= myFileLines.size(); i++)//same as before adds an empty line to comments array same length as others

{

Comments.add(emptyLine);

}

while (currentLinecounter < myFileLines.size())//so while the current line is less than the total amount of lines


{

int currentLinecounter1 = currentLinecounter + 1;
System.out.println("Please rank and comment to option #" + currentLinecounter1 );//asks to input comment and rank and prints out the current file line
System.out.println(myFileLines.get(currentLinecounter));
String currentLine = myFileLines.get(currentLinecounter);

do {

try

{
	String enteredString2 = "";
	numberError = false;
	System.out.println("Rank:");//prints out rank asks user for rank
	enteredString = keyboard.nextLine();
	int currentRanking = Integer.parseInt(enteredString.trim());//gets the ranking from the user and parses it as an int
	int currentRanking1 = currentRanking +1;
	
	if (currentRanking > myFileLines.size() || currentRanking < 1){//checks to make sure the ranking is within the ranking perameters
	
	System.out.println("I'm sorry, " + enteredString + " is not a ranking within the parameters");
	
	}
	if (currentRanking <= myFileLines.size() && currentRanking >= 1){//makes sure entry is within ranking eprameters
	if (Rankings.get(currentRanking).equals(emptyLine))//checks to see if the current element for that rank in the ranking array is an empty line
	{
	Rankings.set(currentRanking, currentLine);//if it is an empty line it sets the current rank (e.g. 6) to that element
	System.out.println("You put " + Rankings.get(currentRanking) + " at rank number " + currentRanking);
	
	}
	else if (!Rankings.get(currentRanking).equals(emptyLine))//if the element in that ranking array is already filled. it adds the rank to the array and shifts the others down one.
	{
	System.out.println("The position is already filled, '"+ Rankings.get(currentRanking) +"' and all subsequent rankings will be shifted down 1");
	Rankings.add(currentRanking, currentLine);//here it adds the current rank
	System.out.println("You put " + Rankings.get(currentRanking) + " at rank number " + currentRanking);
	}
	
	System.out.println("Comment:");
	enteredString2 = keyboard.nextLine();//asks for a comment, same method of adding to an array as above
	
	while (enteredString2.equals("")){//checks to make sure you didnt enter an empty line
		
			System.out.println("You must enter a comment. If you want no comment enter: N/A or no comment.");
			enteredString2 = keyboard.nextLine();
			System.out.println("Comment:");
		}
	
	if (Comments.get(currentRanking).equals(emptyLine))//if it is an empty line it sets the comment to the appropriate element in the comments array
	{
	Comments.set(currentRanking, enteredString2);

	}
	
	else if (!Comments.get(currentRanking).equals(emptyLine))//otherwise it will add the element to the position in the comments array and move the others down
	
	{	
	Comments.add(currentRanking, enteredString2);	
	}
	currentLinecounter++;//keeps counting through each line after youre done with one
	
	}
	
	
	//for (int i = 0; i < Rankings.size(); i++) ** this code prints out the list after each ranking and comment**
	
	//{
	
	//if (!Rankings.get(i).equals(emptyLine))
	
	//{
	
	//System.out.println(Rankings.get(i) + "-" + Comments.get(i));
	
	//}
	
	//else
	
	//{
	
	//continue;
	//}
	
	//}
	}

catch(Exception e){
System.out.println("I'm sorry, " + enteredString + " is not a valid integer");//makes sure that the person entered a valid integer

numberError = true;

}

} while (numberError == true);

}

int z = 1;

System.out.println("Here are your final rankings and comments:");//here we print out the final rankings

for (int i = 0; i < Rankings.size(); i++)//since my method leaves many empty lines, this for loop prints out all of the comments and rankings without the empty lines
{
if (!Rankings.get(i).equals(emptyLine))
{
System.out.println(z + ". " + Rankings.get(i) + " - " + Comments.get(i));
z++;

}
else
{
continue;//if theres no empty line we keep itterating
}
}

int noFile = 0;

int f=1;

while (noFile == 0)//this loop is checking whether or not the user has entered a correct file

{

try {
System.out.println("Please enter a new file in the following format for printing: C:\\users\\your_name\\location\\document_name.txt ");
System.out.println("Example: C:\\users\\John\\Desktop\\Car_Favorites.txt");
System.out.println("NOTE: Entry is case sensitive");
String enteredString4 = keyboard.nextLine();//takes in user input for file output locations

File outfile = new File(enteredString4);

// if file doesnt exist, then create it

if (!outfile.exists()) {
outfile.createNewFile();
}
if (outfile.exists())
{
noFile = 1;

}
FileWriter fw = new FileWriter(outfile.getAbsoluteFile()); //Open the file for writing

BufferedWriter bw = new BufferedWriter(fw);//call the buffered writer method

bw.write("Here is your list of favorites");

bw.newLine();

for (int i = 0; i < Rankings.size(); i++)//write the list of favorites

{
if (!Rankings.get(i).equals(emptyLine))

{
bw.write(f + ". " + Rankings.get(i) + " - " + Comments.get(i) + " ");

bw.newLine();

f++;//cycles through each of the comments and rankings array

}
else {

continue;
}
}

bw.flush(); //Always a good habit to flush when you are through

bw.close();

System.out.println("Done");

} catch (IOException e) {//catches to make sure the file location is valid

noFile = 0;
System.out.println("That is not a valid file location");
}

}

}
}





