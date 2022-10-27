from abc import ABC, abstractmethod

from Framework.Utils.waits import Waits


class BasePage(ABC):

    @abstractmethod
    def __init__(self, locator, name):
        self.__locator = locator
        self.__name = name

    def is_page_open(self):
        try:
            Waits().wait_element_present(self.__locator)
            #  TODO: add to log
            return True
        except Exception as Ex:
            #  TODO: add to log
            return False
