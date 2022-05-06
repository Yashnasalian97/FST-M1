name=input("What is your name:")
age=int(input("What is your age:"))
result= name + " will be 100 in another {} years"
print(result.format(100-age))