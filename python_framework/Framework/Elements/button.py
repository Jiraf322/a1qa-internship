from Framework.Elements.base_elements import BaseElement


class Button(BaseElement):

    def __init__(self, locator, name):
        super().__init__(locator=locator, name=name)

    def get_name(self):
        super(Button, self).get_name()




