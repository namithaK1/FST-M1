import pytest

@pytest.fixture
def initializeList():
    return list(range(11))

@pytest.fixture()
def wallet():
    amount=0
    return amount