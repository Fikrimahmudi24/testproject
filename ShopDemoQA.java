package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShopDemoQA {
    public static void main(String[] args) {
        String path = "D:\\MyTools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;// untuk menambahkan scroll
        driver.manage().window().maximize();
        driver.get("https://shop.demoqa.com/my-account/");
        System.out.println("Open Browser dan Open Google");

        //Untuk mengisi tabel username
        WebElement namaAkunA = driver.findElement(By.xpath("//div[@class='u-column1 col-1']"));
        WebElement namaAkunB = namaAkunA.findElement(By.xpath(".//input[@class='woocommerce-Input woocommerce-Input--text input-text']"));
        namaAkunB.sendKeys("fikrimahmudi24");

        //Untuk mengisi tabel password
        WebElement passwordAkunA = driver.findElement(By.xpath("//div[@class='u-column1 col-1']"));
        WebElement passwordAkunB = passwordAkunA.findElement(By.xpath(".//input[@id='password']"));
        passwordAkunB.sendKeys("Supreme_240600");


        //Untuk Click Login
        driver.findElement(By.name("login")).click();

        //Scraping username
        String namaAkun = driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div/p[1]/strong[1]")).getText();
        System.out.println(namaAkun);

        //Untuk Click Shop Tools
        driver.findElement(By.xpath("//a[@href='https://shop.demoqa.com']")).click();
        System.out.println("click shop tools");

        //Pemilihan Baju, Baju Oversized Pink
        WebElement bajuPinkA = driver.findElement(By.xpath("//div[@class='wpb_wrapper']"));
        WebElement bajuPinkB = bajuPinkA.findElement(By.xpath("//div[@class='noo-sh-product-grid woocommerce ']"));
        WebElement bajuPinkC = bajuPinkB.findElement(By.xpath("//div[@class='noo-sh-product-html columns_3 no_masonry three row is-flex']"));
        WebElement bajuPink = bajuPinkC.findElement(By.xpath(".//div[@class='noo-product-item noo-product-sm-4 not_featured post-1497 product type-product status-publish has-post-thumbnail product_cat-t-shirt product_tag-t-shirt product_tag-women has-featured first instock shipping-taxable purchasable product-type-variable']"));
        bajuPink.click();
        System.out.println("Pemilihan Baju Oversized Pink");

        //Untuk Warna baju
        WebElement pilihWarnaA = driver.findElement(By.xpath("//select[@id='pa_color']"));
        WebElement pilihWarnaB = pilihWarnaA.findElement(By.xpath(".//option[@value='pink']"));
        pilihWarnaB.click();
        System.out.println("Select Warna Baju");

        //Untuk Ukuran Baju
        WebElement ukuranBajuA = driver.findElement(By.xpath("//select[@id='pa_size']"));
        WebElement ukuranBajuB = ukuranBajuA.findElement(By.xpath(".//option[@value='36']"));
        ukuranBajuB.click();
        System.out.println("Select Ukuran Baju");

        //Untuk button Add Chart
        WebElement buttonAddA = driver.findElement(By.xpath("//div[@class='quantity']"));
        WebElement buttonAddB = buttonAddA.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt wp-element-button']"));
        buttonAddB.click();
        System.out.println("Button Add Chart Sukses");

        //Scraping Add chart
        String addC = driver.findElement(By.cssSelector("div[role='alert']")).getText();
        System.out.println(addC);

        //Untuk button view Add Produk
        driver.findElement(By.xpath("//a[@class='button wc-forward wp-element-button']")).click();
        System.out.println("Button View Sukses");


        //assert login
        if(namaAkun.equals("fikrimahmudi24")){
            System.out.println("Anda Berhasil Login");
        }else {
            System.out.println("Login Anda Gagal");
        }

        //assert chart
        if(addC.contains("pink drop shoulder oversized t shirt” has been added to your cart")){
            System.out.println("Produk berhasil ditambahkan");
        }else {
            System.out.println("Produk gagal ditambahkan");
        }

        delay();
        driver.quit();
        System.out.println("Quit ShopDemoQA");
    }
    public static void delay() {
        try {
            Thread.sleep(70000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
