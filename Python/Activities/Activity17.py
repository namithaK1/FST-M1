import pandas as pd

data = {
    'Usernames': ['Admin', 'Charles','Deku'],
    'Password':['password','Charl13','AllMight']
}
dataFrame = pd.DataFrame(data)
print(dataFrame)
dataFrame.to_csv("Users.csv", index=False)