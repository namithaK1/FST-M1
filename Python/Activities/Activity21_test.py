import pytest

def testSum():
    n1=2
    n2=5
    assert n1+n2==7

def testDiff():
    n1=2
    n2=2
    assert n1-n2==0

def testMul():
    n1=25
    n2=5
    assert n1*n2!=4

def testDiv():
    n1=90
    n2=9
    assert n1/n2<10
