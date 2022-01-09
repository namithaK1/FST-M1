try:
    #x=a/0
    print(x)
except NameError:
    print("Element is not defined")
except:
    print("An exception has occured")
else:
    print("No exception")