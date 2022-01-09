for i in range(1,11):
    print("Table of ",i)
    for j in range(1,11):
        print(i,"*",j,"=", i*j)
    print("-----------------------")

i=int(input("Enter the number to find its multiplication table"))
for j in range(1,11):
        print(i,"*",j,"=", i*j)