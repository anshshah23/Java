import random
import string

def generate_substitution_key():
    letters = string.ascii_uppercase
    shuffled = list(letters)
    random.shuffle(shuffled)
    return {letters[i]: shuffled[i] for i in range(len(letters))}

def substitution_encrypt(plaintext, sub_key):
    return ''.join(sub_key.get(char, char) for char in plaintext.upper())

def substitution_decrypt(ciphertext, sub_key):
    reverse_key = {v: k for k, v in sub_key.items()}
    return ''.join(reverse_key.get(char, char) for char in ciphertext)

def transposition_encrypt(text, key):
    num_cols = len(key)
    num_rows = -(-len(text) // num_cols)  # Ceiling division
    grid = [[' ' for _ in range(num_cols)] for _ in range(num_rows)]
    index = 0
    
    for row in range(num_rows):
        for col in range(num_cols):
            if index < len(text):
                grid[row][col] = text[index]
                index += 1
    
    key_order = sorted(range(len(key)), key=lambda k: key[k])
    return ''.join(grid[row][col] for col in key_order for row in range(num_rows))

def transposition_decrypt(ciphertext, key):
    num_cols = len(key)
    num_rows = -(-len(ciphertext) // num_cols)
    grid = [['' for _ in range(num_cols)] for _ in range(num_rows)]
    key_order = sorted(range(len(key)), key=lambda k: key[k])
    
    index = 0
    for col in key_order:
        for row in range(num_rows):
            if index < len(ciphertext):
                grid[row][col] = ciphertext[index]
                index += 1
    
    return ''.join(''.join(row) for row in grid).strip()

def encrypt(text, sub_key, trans_key):
    step1 = substitution_encrypt(text, sub_key)
    step2 = transposition_encrypt(step1, trans_key)
    return step2

def decrypt(ciphertext, sub_key, trans_key):
    step1 = transposition_decrypt(ciphertext, trans_key)
    step2 = substitution_decrypt(step1, sub_key)
    return step2

# Example usage
sub_key = generate_substitution_key()
trans_key = "31452"
plaintext = "HELLO WORLD"

ciphertext = encrypt(plaintext.replace(" ", ""), sub_key, trans_key)
print("Encrypted:", ciphertext)
decrypted_text = decrypt(ciphertext, sub_key, trans_key)
print("Decrypted:", decrypted_text)