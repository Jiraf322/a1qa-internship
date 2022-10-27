import pytest

from Framework.Browser.driver_utils import DriverUtils
from Framework.Utils.actions import Actions

from Project.Pages.main_page import MainPage
from Project.Pages.alert_page import AlertPage
from Project.Pages.nested_frames_page import NestedFramesPage
from Project.Pages.frames_page import FramesPage
from Project.Pages.browser_windows_page import BrowserWindowsPage
from Project.Pages.web_tables_page import WebTablesPage
from Project.Pages.links_page import LinksPage
from Project.Pages.nav_bar import NavBar


class TestToolsQA:
    def test_alerts(self):
        DriverUtils.go_to_base_url()
        assert MainPage().is_page_open(), 'Main page is not opened'
        MainPage().remove_footer_ad()
        MainPage().go_to_the_alerts_frame_windows()
        DriverUtils.refresh_page()

        MainPage().remove_footer_ad()
        NavBar().click_button_alert_dropdown()
        assert AlertPage().is_alerts_open(), 'Dropdown "Alerts" is not chosen'

        AlertPage().click_see_alert_button()
        DriverUtils().accept_alert()
        assert DriverUtils().is_alert_present() is False, 'Alert is not closed'

        AlertPage().click_confirm_alert_button()
        DriverUtils().accept_alert()
        assert DriverUtils().is_alert_present() is False, 'Alert is not closed'
        assert AlertPage().is_alert_label_ok(), 'Text "You selected Ok" is not found'

        random_name = Actions.get_random_name()

        AlertPage().click_alert_prompt_button()
        DriverUtils().send_text_alert(random_name)
        DriverUtils().accept_alert()
        assert AlertPage().get_label_prompt_text() == f'You entered {random_name}', f'wrong result'

    def test_frames(self):
        DriverUtils.go_to_base_url()
        assert MainPage().is_page_open(), 'Main page is not opened'
        MainPage().remove_footer_ad()
        MainPage().go_to_the_alerts_frame_windows()
        DriverUtils.refresh_page()
        MainPage().remove_footer_ad()

        NavBar().click_button_nested_frames_dropdown()
        assert NestedFramesPage().is_nested_frames_open(), f'Dropdown "Nested Frames" is not chosen'

        parent, child = NestedFramesPage().get_text_nested_child_frame()

        assert parent == 'Parent frame', 'parent frame does not exists'
        assert child == 'Child Iframe', 'child frame does not exists'

        NavBar().click_button_frames_dropdown()
        assert FramesPage().is_frames_open(), f'Dropdown "Frames" is not chosen'
        assert FramesPage().get_text_big_frame() == FramesPage().get_text_small_frame(), f'text in frames is not equal'

    @pytest.mark.parametrize('person', DriverUtils.get_users())
    def test_tables(self, person):
        DriverUtils.go_to_base_url()
        assert MainPage().is_page_open(), f'Main page is not opened'

        MainPage().go_to_the_elements()
        DriverUtils.refresh_page()
        MainPage().remove_footer_ad()

        NavBar().click_button_web_tables_dropdown()
        assert WebTablesPage().is_web_tables_open(), f'Dropdown "Web Tables" is not chosen'
        WebTablesPage().click_button_add()

        WebTablesPage().fill_info_person(person)

        added_person = [person.first_name, person.last_name, person.age, person.email, person.salary, person.department]
        WebTablesPage().click_button_submit()

        list_of_people = WebTablesPage().get_list_of_people()

        assert added_person in list_of_people, f'new person is not added'

        WebTablesPage().click_button_delete_new_person()

        new_list_of_people = WebTablesPage().get_list_of_people()

        assert list_of_people != new_list_of_people, f'new person is not deleted'
        assert added_person not in new_list_of_people, f'new person is not deleted'

    def test_handles(self):
        DriverUtils.go_to_base_url()
        assert MainPage().is_page_open(), 'Main page is not opened'
        MainPage().remove_footer_ad()
        MainPage().go_to_the_alerts_frame_windows()
        DriverUtils.refresh_page()
        MainPage().remove_footer_ad()

        NavBar().click_browser_windows_dropdown()
        assert BrowserWindowsPage().is_browser_windows_open(), f'page with form "Browser Windows" is not opened'

        BrowserWindowsPage().click_button_new_tab()
        BrowserWindowsPage().switch_to_new_page()
        assert BrowserWindowsPage().is_sample_page_open(), f'sample page is not open'

        DriverUtils().close_current_window()
        BrowserWindowsPage().switch_to_main_page()
        assert BrowserWindowsPage().is_browser_windows_open(), f'page with form "Browser Windows" is not opened'

        NavBar().click_button_elements()
        NavBar().click_button_links_dropdown()
        LinksPage().click_button_home_link()
        LinksPage().switch_to_new_page()
        assert MainPage().is_page_open(), 'Main page is not opened'

        LinksPage().switch_to_main_page()
        assert LinksPage().is_links_open(), f'page with form "Links" is not opened'
