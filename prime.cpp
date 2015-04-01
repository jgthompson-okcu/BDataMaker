#include <iostream>
using namespace std;
int main()
{
   int i, j;
   for ( i = 2; i < 1000; i++ )
   {
        for ( j = 2; j <= i/2; j++ )
        {
            if ( ! ( i % j ) ) break;
        }
 
        if ( j > i / 2 ) cout << i << endl;
    }
 
   return 0;
}


