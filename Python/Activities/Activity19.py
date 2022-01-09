import pandas
from pandas import ExcelWriter

data = {
    'FirstName': ['Satvik','Avinash','Lahri'],
    'LastName': ['Shah', 'Kati', 'Rath'],
    'Email': ['satshah@example.com', 'avinashk@example.com', 'lahri.rath@example.com	'],
    'PhoneNumber': ['987654321','234567891', '678987654']
}

toWriteDataFrame = pandas.DataFrame(data)
print(toWriteDataFrame)
writer = ExcelWriter("UserDetails.xlsx")

toWriteDataFrame.to_excel(writer,"Sheet1",index=False)

writer.save()