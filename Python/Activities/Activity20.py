import pandas as pd
data = pd.read_excel("UserDetails.xlsx", sheet_name="Sheet1")
print(data)

print(data.shape)

print(data["Email"])

print(data.sort_values("Email"))