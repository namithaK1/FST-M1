import pytest

# @pytest.fixture
# def initializeList():
#     return [0,1,2,3,4,5,6,7,8,9,10]

@pytest.mark.activity23
def testAddListElements(initializeList):
    sum=0
    for i in initializeList:
        sum+=i
    assert sum==55

