diction = {'apple':150, 'banana':50, 'orange':60, 'pineappl':40}
available=input("Enter fruit ")
for fru in diction:
    if(fru==available):
        print(available, " is available for price", diction[fru])
        break
else:
    print(available, " is not available")

'''if available in diction:
    print(available, " is available for price", diction[fru])
else:
    print(available, " is not available") '''
