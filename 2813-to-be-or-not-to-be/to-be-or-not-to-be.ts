type ToBeOrNotToBe = {
    toBe: (val: any) => boolean;
    notToBe: (val: any) => boolean;
};

function expect(val: any): ToBeOrNotToBe {
    const throwError = (str: string) => {
        throw new Error(str);
    }

    const obj: ToBeOrNotToBe = {
        toBe: (val2) => {
            return val2 === val || throwError("Not Equal");
        },
        notToBe: (val2) => {
            return val2 !== val || throwError("Equal");
        }
    }

    return obj;
}