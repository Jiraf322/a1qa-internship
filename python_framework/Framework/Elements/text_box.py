from Framework.Elements.base_elements import BaseElement
from Framework.Utils.actions import Actions


class TextBox(BaseElement):

    def __init__(self, locator, name):
        super().__init__(locator=locator, name=name)

    def get_name(self):
        super(TextBox, self).get_name()

