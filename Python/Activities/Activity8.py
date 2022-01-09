numList=list(input("Enter list of number").split(" "))
print(numList)
if numList[0]==numList[len(numList)-1]:
#if numl[0]==numList[-1]:
    print("True")
else:
    print("False")