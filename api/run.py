import json
import yaml
import sys
import argparse
import requests

def parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument("--httpRequest", required=True)
    parser.add_argument("--endPoint", required=True)
    return  parser.parse_args()

def main():
    args = parse_args()
    print (args)
    if args.httpRequest == "get":
        r = requests.get(args.endPoint)
        return r, str(r.content)
    elif args.httpRequest == "post":
        pass
    elif args.httpRequest == "patch":
        pass
    else:
        raise Exception("not support http request type")

if __name__ == '__main__':
    r = main()
    print (r)
