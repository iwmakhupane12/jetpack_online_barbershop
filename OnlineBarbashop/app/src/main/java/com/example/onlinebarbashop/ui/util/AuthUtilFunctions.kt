package com.example.onlinebarbashop.ui.util

fun phoneNumValidation(phoneNum: String): String {
    if (phoneNum == "")
        return "Please input phone number"

    if (phoneNum.isNotBlank()) {
        if (!android.util.Patterns.PHONE.matcher(phoneNum).matches())
            return "Phone number is invalid. +27 629760527"
    }

    return ""
}

fun emailValidation(emailAddress: String): String {
    if (emailAddress == "")
        return "Please input email address"

    if (emailAddress.isNotBlank())
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches())
            return "Email address is invalid. iwmakhupane12@gmail.com"

    return ""
}

fun namesValidation(names: String): String {
    if (names.isBlank())
        return "Please input at least one name"

    return ""
}

fun passwordValidation(password: String): String {
    if (password.isBlank())
        return "Please input password"

    return ""
}

fun passwordMatch(
    confirmPassword: String,
    password: String,
): String {
    if (confirmPassword.isNotBlank())
        if (confirmPassword != password)
            return "Please make sure your passwords match"

    return ""
}

/*TODO: Incorrect credentials for login screen*/