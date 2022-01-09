from typing import Tuple


numTuple=tuple(input("Enter the numbers").split(' '))
print(numTuple)
for i in numTuple:
    if(int(i)%5==0):
        print(i)