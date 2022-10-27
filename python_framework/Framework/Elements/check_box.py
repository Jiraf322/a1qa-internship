from Framework.Elements.base_elements import BaseElement


class CheckBox(BaseElement):

    def __init__(self, locator, name):
        super().__init__(locator=locator, name=name)

    def get_name(self):
        super(CheckBox, self).get_name()

    def is_checked(self):
        if 'uncheck' in self.get_text('class'):
            return False
        return True

    def check(self):
        if self.is_checked():
            self.click()

    def uncheck(self):
        if not self.is_checked():
            self.click()
