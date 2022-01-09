def sum(num):
    add=0
    for n in num:
        add+=int(n)
    return add

ele=list(input("Enter list of numbers ").split(" "))
total = sum(ele)
print("Sum of list ", ele, " = ", total)