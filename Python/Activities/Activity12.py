def sumOfNum(num):
    if num<=1:
        return num
    else:
        return num + sumOfNum(num-1)

number = int(input("Enter the number "))
sum = sumOfNum(number)
print(sum)