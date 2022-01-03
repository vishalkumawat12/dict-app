import requests
def meaning(txt):

    url = "https://api.dictionaryapi.dev/api/v2/entries/en/"+str(txt)
    r = requests.get(url)
    data = r.json()
    return str(data[0]['meanings'][0]['definitions'][0]['definition'])
