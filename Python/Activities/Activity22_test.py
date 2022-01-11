import pytest

@pytest.mark.arithmetic
def testSum():
    n1=2
    n2=5
    assert n1+n2==7

@pytest.mark.arithmetic
def testDiff():
    n1=2
    n2=2
    assert n1-n2==0

@pytest.mark.activity
def testMul():
    n1=25
    n2=5
    assert n1*n2!=4

@pytest.mark.activity
def testDiv():
    n1=90
    n2=9
    assert n1/n2<=10

@pytest.mark.others
def testNum():
    n1=90
    n2=9
    assert n1==n2