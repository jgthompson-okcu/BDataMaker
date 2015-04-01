1.#include <iostream>

2.using namespace std;

3. 

4.int main()

5.{

6.    int i, j;

7. 

8.    for ( i = 2; i < 100000; i++ )

9.    {

10.        for ( j = 2; j <= i/2; j++ )

11.        {

12.            if ( ! ( i % j ) ) break;

13.        }

14. 

15.        if ( j > i / 2 ) cout << i << endl;

16.    }

17. 

18.    return 0;

19.}


