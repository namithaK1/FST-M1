while True:
    user1Choice = input("Enter user1 choice ")
    user2Choice = input("Enter user2 choice ")
    if(user1Choice==user2Choice):
        print("Tied")
    elif(user1Choice.lower()=="rock"):
        if(user2Choice.lower()=="paper"):
            print("User 1 = rock, User 2 = paper -> *User 2 wins*")
        else: #scissors
            print("User 1 = rock, User2 = scissor -> *User 1 wins*")

    elif(user1Choice.lower()=="paper"):
        if(user2Choice.lower()=="rock"):
            print("User 1 = paper, User 2 = rock -> *User 1 wins*")
        else: #scissors
            print("User 1 = paper, User2 = scissor -> *User 2 wins*")

    elif(user1Choice.lower()=="scissor"):
        if(user2Choice.lower()=="paper"):
            print("User 1 = scissor, User 2 = paper -> *User 1 wins*")
        else: #scissors
            print("User 1 = scissor, User2 = rocks -> *User 2 wins*")
    else:
        print("Invalid choice")
    
    x = input("Do you want to play again (yes or no)??")
    if x=="yes":
        continue
    else:
        #break
        raise SystemExit
