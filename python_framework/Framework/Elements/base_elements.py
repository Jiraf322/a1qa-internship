from abc import ABC, abstractmethod

from Framework.Utils.actions import Actions
from Framework.Utils.logger import Logger


class BaseElement(ABC):

    @abstractmethod
    def __init__(self, locator, name):
        self._locator = locator
        self._name = name

    @abstractmethod
    def get_name(self):
        return self._name

    def click(self):
        try:
            Logger.catch_info(f'click {self._name}')
            Actions.click_on_element(self._locator)
        except Exception as ex:
            Logger.catch_warning(f'failed to click {self._name} during {ex}')

    def hover(self):
        try:
            Logger.catch_info(f'hovering and clicking {self._name}')
            Actions.hover_on_element(self._locator)
        except Exception as ex:
            Logger.catch_warning(f'failed to hover and click {self._name} during {ex}')

    def get_text(self, data=None):
        try:
            Logger.catch_info(f'getting text from {self._name}')
            return Actions.get_data(self._locator, data)
        except Exception as ex:
            Logger.catch_warning(f'failed to get text from {self._name} during {ex}')

    def is_displayed(self):
        try:
            Logger.catch_info(f'searching for {self._name}...')
            return Actions.is_element_visible(self._locator)
        except Exception as ex:
            Logger.catch_warning(f'failed to search for {self._name} during {ex}')

    def send_text(self, text):
        try:
            Logger.catch_info(f'sending text to {self._name}')
            Actions.send_text(self._locator, text)
        except Exception as ex:
            Logger.catch_warning(f'failed to send text to {self._name} during {ex}')

    def clear(self):
        try:
            Logger.catch_info(f'clearing {self._name}')
            Actions.is_element_visible(self._locator).clear()
        except Exception as ex:
            Logger.catch_warning(f'failed to clear {self._name} during {ex}')





