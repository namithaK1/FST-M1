import pytest

@pytest.mark.parametrize("earned,spent,expected", [(30,10,20),(20,2,18)])
def testMyWallet(wallet,earned,spent,expected):
    print("\nMy wallet initially has", wallet)
    wallet+=earned
    print("My wallet after earning", wallet) 
    wallet-=spent
    print("My wallet after spending", wallet)
    assert wallet==expected