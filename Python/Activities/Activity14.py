def fibo(num):
    if num<=1:
        return num
    else:
        return fibo(num-1) + fibo(num-2)

n=int(input("Enter number to find fibonacci series "))

for i in range(n):
    print(fibo(i)," ", end="")