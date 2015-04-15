//===========================================================================
// Name        : test.cpp
// Author      : Jeff
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================
// ConsoleApplication5.cpp : Defines the entry point for the console application.
//

#include "includes.h"
#include "MyClass.h"
#include "Tokenize.h"
#include <sys/stat.h>

using std::string;
using std::ofstream;

bool fileExists(const std::string& filename)
{
    struct stat buf;
    if (stat(filename.c_str(), &buf) != -1)
    {
        return true;
    }
    return false;
}
bool writefile(int howmany)
{
        string filename = "test.txt";
	if (fileExists(filename)) return true;
	
	ofstream ofs(filename, ofstream::out);
	ofs << "helloooooooooom,cool cool,another string,laaaaast one";
	ofs.close();
	return true;
}

bool readfile2(int howman)
{

	std::cout << "READFILE2 \n";
	//load the text file and put it into a single string:
	std::ifstream ifs("test.txt", std::ifstream::in);

	std::string line;
	long int x = 0;
	while (getline(ifs, line))
	{
	    x++;
	    // istringstream iss(line);
	    // int a, b;
	    // if (!(iss >> a >> b)) { break; } // error
	    std::vector<std::string> v;

	    std::string delimiters = ", ";
	    tokenize( v, line, delimiters );

	    Prospect *p = new Prospect();


	    p->fillProspectFromTokens(v);



	    for (unsigned int i = 0;  i < v.size();   i++)
	    	std::cout << v[i] << std::endl;


	}
	
	std::cout << "lines read: " << x << std::endl;

	return true;

}

namespace Patch {


#ifdef _MSC_VER
	#define thread_local
#endif

std::stringstream ss;

template < typename T >  std::string to_string( const T& n )
{
	   ss.str("");
	   ss.clear();
	   ss << n;
	   return ss.str();
}


} /* namespace Patch */

int main()
{
	writefile(100);
	readfile2(100);
	return 0;

	/*

	vector<MyClass> vec;

	for (int x = 0; x < 100; x++)
	{
		MyClass m;
		m.setValue1("one " + Patch::to_string(x));
		m.setValue2("two " + Patch::to_string(x));
		vec.push_back(m);
	}
	cout << "vec size = " << vec.size() << endl;
	cout << vec[0].getValue1() << " 0 " << vec[0].getValue2();
	cout << endl;

	{
		MyClass m2;
		m2.setValue1("three");
		m2.setValue2("four");
		vec.push_back(m2);
	}
	cout << "vec size = " << vec.size() << endl;
	cout << vec[0].getValue1() << " 00 " << vec[0].getValue2();
	cout << endl;
	cout << vec[1].getValue1() << " 01 " << vec[1].getValue2();
	cout << endl;

	for (auto & i : vec)
	{

		cout << i.getValue1() + ", " + i.getValue2() << ", ";
	}
	cout << endl;


	for (auto i = vec.begin(); i != vec.end(); ++i)
	{

		cout << (*i).getValue1() + ", " + (*i).getValue2() << ", ";
	}
	cout << endl;

	for (unsigned int i = 0; i < vec.size(); i++)
	{
		cout << vec[i].getValue1() << " " << vec[i].getValue2() << " ";

		vec[i].setValue1("blah");

	}
	cout << endl;

	vec.clear();

	return 0;

	 */

}


//bool readfile(int howmany){
//	ifstream ifs("test.txt", ifstream::in);
//
//	stringstream buffer;
//	buffer << ifs.rdbuf();
//
//	string test = buffer.str();
//	cout << "Hello! " << test << endl << endl;
//
//	//create variables that will act as "cursors". we'll take everything between them.
//	size_t pos1 = 0;
//	size_t pos2;
//
//	//create the array to store the strings.
//	std::string str[4];
//
//	for (int x = 0; x <= 3; x++){
//		pos2 = test.find(",", pos1); //search for the bar "|". pos2 will be where the bar was found.
//		str[x] = test.substr(pos1, (pos2 - pos1)); //make a substring, wich is nothing more
//		//than a copy of a fragment of the big string.
//		std::cout << str[x] << std::endl;
//		std::cout << "pos1:" << pos1 << ", pos2:" << pos2 << std::endl;
//		pos1 = pos2 + 1; // sets pos1 to the next character after pos2.
//		//so, it can start searching the next bar |.
//	}
//
//	ifs.close();
//	return true;
//}


