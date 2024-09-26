# How to Change MySQL Password in XAMPP on Windows

Changing the MySQL password in XAMPP on Windows involves a few steps. Here’s a straightforward guide to help you through the process:

## Step 1: Open XAMPP Control Panel

1. **Launch XAMPP**: Start the XAMPP Control Panel by clicking on its icon.
2. **Stop MySQL**: Ensure that the MySQL service is stopped by clicking the "Stop" button next to MySQL.

## Step 2: Open a Command Prompt

1. **Open Command Prompt**: Press `Win + R`, type `cmd`, and hit Enter to open the Command Prompt.
2. **Navigate to MySQL Directory**: Type the following command and press Enter:
    ```bash
    cd C:\xampp\mysql\bin
    ```

## Step 3: Start MySQL in Safe Mode

1. **Run MySQL in Safe Mode**: Type the following command to start MySQL without loading the grant tables, which allows you to change the root password without needing the old one:
    ```css
    mysqld --skip-grant-tables
    ```
   Leave this Command Prompt window open as MySQL will run in this mode.

## Step 4: Open a New Command Prompt

1. **Open a New Command Prompt**: Press `Win + R`, type `cmd`, and hit Enter.
2. **Navigate to MySQL Directory Again**: Type:
    ```bash
    cd C:\xampp\mysql\bin
    ```

## Step 5: Change the MySQL Password

1. **Access MySQL**: Enter the MySQL prompt with:
    ```bash
    mysql -u root
    ```
2. **Run the Password Update Command**: Replace `newpassword` with your desired password:
    ```sql
    FLUSH PRIVILEGES;
    ALTER USER 'root'@'localhost' IDENTIFIED BY '1234';
    ```
    If you are using MySQL 5.7 or earlier, the command might be:
    ```sql
    SET PASSWORD FOR 'root'@'localhost' = PASSWORD('1234');
    ```
    > Don't use the method above
3. **Exit MySQL Prompt**: Type `exit` and press Enter.

## Step 6: Restart MySQL Normally

1. **Close Safe Mode Command Prompt**: Close the Command Prompt window running MySQL in safe mode.
2. **Return to XAMPP Control Panel**: Go back to the XAMPP Control Panel and start the MySQL service normally by clicking the "Start" button.

## Step 7: Update XAMPP Configuration (If Needed)

1. **Update Configuration Files**: If you have configured MySQL in XAMPP to use a different user/password, update `config.inc.php` (usually located in `C:\xampp\phpMyAdmin`) with the new password.

## Step 8: Test the New Password

1. **Open phpMyAdmin**: Go to your browser and navigate to `http://localhost/phpmyadmin`.
2. **Log In**: Use `root` as the username and your new password to log in.

That’s it! You’ve successfully changed the MySQL password in XAMPP on Windows. If you run into any issues, make sure that MySQL has fully stopped before restarting it normally and double-check the commands you entered.
