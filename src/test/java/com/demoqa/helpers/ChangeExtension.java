package com.demoqa.helpers;

import java.io.File;

public class ChangeExtension {

    public static File changeExtension(File downloadedFile, String desiredExtension) {
        File newFile = null;
        if (downloadedFile.exists()) {
            // Получаем путь к скачанному файлу
            String filePath = downloadedFile.getAbsolutePath();

            // Создаем новый путь к файлу с желаемым расширением
            String newFilePath = filePath + desiredExtension;

            // Переименовываем файл
            newFile = new File(newFilePath);
            if (downloadedFile.renameTo(newFile)) {
                System.out.println("Файл успешно переименован.");
                return newFile;
            } else {
                System.out.println("Ошибка при переименовании файла.");
                return null;
            }
        } else {
            System.out.println("Скачанный файл не найден.");
            return null;
        }
    }
}
