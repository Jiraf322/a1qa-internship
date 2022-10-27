from loguru import logger
from Framework.Resources.json_path import JsonPath


class Logger:

    @staticmethod
    def catch_info(msg: str):
        logger.add(JsonPath.framework_logs, level="INFO", rotation="1 MB")
        logger.info(msg)
        logger.remove()

    @staticmethod
    def catch_warning(msg: str):
        logger.add(JsonPath.framework_logs, level="WARNING", rotation="1 MB")
        logger.warning(msg)
        logger.remove()
