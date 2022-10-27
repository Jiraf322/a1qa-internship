from selenium.webdriver.common.by import By
from selenium.common.exceptions import TimeoutException

from Framework.Pages.base_page import BasePage
from Framework.Elements.button import Button
from Framework.Elements.label import Label
from Framework.Elements.text_box import TextBox
from Framework.Utils.waits import Waits


class WebTablesPage(BasePage):

    UNIQ_LOCATOR = (By.ID, 'app')
    HEADER = (By.XPATH, "//*[@class = 'main-header']")

    BUTTON_ADD = (By.ID, 'addNewRecordButton')
    BUTTON_SUBMIT = (By.ID, 'submit')
    TABLE = (By.XPATH, "//*[@class='rt-tr-group']")
    # TODO: write correct locator
    REG_FORM_OPENED = (By.XPATH, "//*[@id = 'app' and @aria-hidden = 'true']")
    BUTTON_DELETE_NEW_PERSON = (By.ID, 'delete-record-4')

    INPUT_FIRST_NAME = (By.ID, 'firstName')
    INPUT_LAST_NAME = (By.ID, 'lastName')
    INPUT_EMAIL = (By.ID, 'userEmail')
    INPUT_AGE = (By.ID, 'age')
    INPUT_SALARY = (By.ID, 'salary')
    INPUT_DEPARTMENT = (By.ID, 'department')
    REG_FORM = (By.ID, 'registration-form-modal')

    def __init__(self):
        super().__init__(locator=self.UNIQ_LOCATOR, name=self.__class__.__name__)
        self.label_web_tables = Label(self.HEADER, 'label_web_tables')
        self.label_reg_form = Label(self.REG_FORM, 'registration_form')
        self.button_add = Button(self.BUTTON_ADD, 'button_add')
        self.button_submit = Button(self.BUTTON_SUBMIT, 'button_submit')
        self.label_opened_reg_form = Label(self.REG_FORM_OPENED, 'reg_form_open')
        self.button_delete_new_person = Button(self.BUTTON_DELETE_NEW_PERSON, 'button_delete_new_person')

        self.text_box_first_name = TextBox(self.INPUT_FIRST_NAME, 'text_box_first_name')
        self.text_box_last_name = TextBox(self.INPUT_LAST_NAME, 'text_box_last_name')
        self.text_box_email = TextBox(self.INPUT_EMAIL, 'text_box_email')
        self.text_box_age = TextBox(self.INPUT_AGE, 'text_box_age')
        self.text_box_salary = TextBox(self.INPUT_SALARY, 'text_box_salary')
        self.text_box_department = TextBox(self.INPUT_DEPARTMENT, 'text_box_department')

    def is_page_open(self):
        return super(WebTablesPage, self).is_page_open()

    def is_web_tables_open(self):
        if self.label_web_tables.get_text() == 'Web Tables':
            return True
        return False

    def click_button_add(self):
        self.button_add.click()

    def click_button_submit(self):
        self.button_submit.click()

    def is_reg_form_open(self):
        self.label_reg_form.is_displayed()

    def fill_info_person(self, person):
        self.text_box_first_name.send_text(person.first_name)
        self.text_box_last_name.send_text(person.last_name)
        self.text_box_email.send_text(person.email)
        self.text_box_age.send_text(person.age)
        self.text_box_salary.send_text(person.salary)
        self.text_box_department.send_text(person.department)

    def get_list_of_people(self):
        people = []
        for item in Waits().wait_all_elements_present(self.TABLE):
            people.append(item.text.splitlines())
        return people

    #  TODO: добавить проверку reg form закрыта
    def is_reg_form_closed(self):
        try:
            self.label_opened_reg_form.is_displayed()
            return False
        except TimeoutException:
            return True

    def click_button_delete_new_person(self):
        self.button_delete_new_person.click()
