from Framework.Elements.base_elements import BaseElement


class Label(BaseElement):

    def __init__(self, locator, name):
        super().__init__(locator=locator, name=name)

    def get_name(self):
        super(Label, self).get_name()